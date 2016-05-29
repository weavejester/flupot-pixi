(ns flupot.pixi
  (:require-macros [flupot.pixi :as pixi])
  (:require [flupot.core :as core]
            [cljsjs.react-pixi]))

(pixi/define-pixi-factories)
(pixi/define-pixi-fns)
