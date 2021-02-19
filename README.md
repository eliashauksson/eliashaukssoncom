# eliashaukssoncom

This is the sourcecode of my personal website. It is written in Clojure (Backend) and in Clojurescript (Frontend).

## Prerequisites

You will need

- [Leiningen][] installed.

[leiningen]: https://github.com/technomancy/leiningen

- [Node.js][] and [npm][] installed.

[Node.js]: https://nodejs.org/en/
[npm]: https://www.npmjs.com

## Running

To start shadow-cljs for hot-reloading, run:

	npm start

## Build

To build a standalone jar file, run:

	npx shadow-cljs release app
	lein ring uberjar

The standalone file will be in the target folder.
