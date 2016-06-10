(ns example.core
  (:require [brutha.core :as br]
            [flupot.pixi :as pixi]
            [flupot.dom :as dom]))

(enable-console-print!)

(defn outline-filter [{[w h] :size}]
  (PIXI.AbstractFilter.
   nil
   "precision mediump float;

   varying vec2 vTextureCoord;
   uniform sampler2D uSampler;
   uniform vec2 dimensions;

   void main(void) {
       vec2 pixelSize  = vec2(1.0) / dimensions.xy;
       vec4 pixel      = texture2D(uSampler, vTextureCoord);
       vec4 pixelUp    = texture2D(uSampler, vTextureCoord - vec2(0.0, pixelSize.y));
       vec4 pixelDown  = texture2D(uSampler, vTextureCoord + vec2(0.0, pixelSize.y));
       vec4 pixelLeft  = texture2D(uSampler, vTextureCoord - vec2(pixelSize.x, 0.0));
       vec4 pixelRight = texture2D(uSampler, vTextureCoord + vec2(pixelSize.x, 0.0));

       if (pixel.a == 0.0 && (pixelUp.a    > 0.0 ||
                              pixelDown.a  > 0.0 ||
                              pixelLeft.a  > 0.0 ||
                              pixelRight.a > 0.0)) {
         pixel = vec4(1.0, 0.0, 0.0, 1.0);
       }

       gl_FragColor = pixel;
   }"
   #js {:dimensions #js {:type "2f" :value #js [w h]}}))

(def canvas
  (br/component
   (fn [{:keys [rotation]}]
     (pixi/stage
      {:width 400, :height 300}
      (pixi/text {:x 100, :y 100, :rotation rotation, :text "Hello World"})
      (pixi/sprite {:x 300, :y 100
                    :rotation rotation
                    :image "bunny.png"
                    :filters [(outline-filter {:size [400.0, 300.0]})]})))))

(def content
  (br/component
   (fn [state]
     (dom/div
      (dom/p "Example")
      (canvas state)))))

(defn bind [state component root]
  (br/mount (component @state) root)
  (add-watch state ::bind (fn [_ _ _ s] (br/mount (component s) root))))

(defn animate [state]
  (swap! state update :rotation + 0.01)
  (js/setTimeout #(animate state) 16))

(let [state (atom {:rotation 0})
      app   (.getElementById js/document "app")]
  (bind state content app)
  (animate state))
