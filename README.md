# chch

FIXME

## Usage
Launch the application by issuing one of the following commands:

```shell
lein run [host <host>] [port <port>]
```

You can generate a standalone jar and run it:

```shell   
lein uberjar
java -jar target/chch-0.1.0-SNAPSHOT-standalone.jar
```

You can also generate a war to deploy on a server like Tomcat, Jboss...

```shell
lein ring uberwar
```

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
