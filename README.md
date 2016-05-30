# Flupot-Pixi

A ClojureScript wrapper around [react-pixi][], a library for
controlling [Pixi.js][] through [React][]. As the name suggests,
Flupot-Pixi is based on the [Flupot][] library.

[react-pixi]: https://github.com/Izzimach/react-pixi
[pixi.js]: http://www.pixijs.com/
[react]: https://facebook.github.io/react/
[flupot]: https://github.com/weavejester/flupot

## Installation

Add the following to your project `:dependencies`:

    [flupot/pixi "0.1.0-SNAPSHOT"]

## Usage

There are seven functions, each corresponding to a class in react-pixi:

- `bitmap-text`
- `container`
- `sprite`
- `sprite-batch`
- `stage`
- `text`
- `tiling-sprite`

The first argument may be a map of options, similar to how Flupot
elements work.

For example:

```clojure
(require '[flupot.pixi :as pixi])

(defn example []
  (pixi/stage
   {:width 400, :height 300}
   (pixi/text {:x 100, :y 100, :text "Hello World"})))
```

## License

Copyright © 2016 James Reeves

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
