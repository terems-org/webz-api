# WebZ API v0.9 beta ([Pedesis](https://www.pinterest.com/teremterem/pedesis-from-ancient-greek-a-leaping/))

WebZ API serves two purposes:
 1. At one hand it lets new WebZ Filters be developed and then plugged into [WebZ Server](https://github.com/terems-org/webz-server) in order to have some custom server side java logic in place.
 1. At the other hand it also allows the server to be extended from the other end - custom file sources can be implemented: for ex. adapters for external storages like Dropbox, adapters for SCM providers like GitHub (Git adapters) etc.

> ***ATTENTION! Unlike WebZ API, WebZ Server itself is licensed under GNU Affero GPL v3.0*** *and this has the following consequences:*
>  1. *The extensions you develop using WebZ API interfaces are not affected by Affero GPL by themselves.*
>  1. *However, right now the only way to extend WebZ Server in any way (including custom WebZ Filters) is to package the extensions together with the server, and the moment you do this your extensions will automatically become "contaminated" by Affero GPL.*

In the future certain levels of flexibility will be introduced to resolve this situation - certain types of extensions will become possible without affecting the server's package (most likely it will be WebZ Filters)...

How To Use
------

Add the following maven dependency to your **pom.xml**:
```
<dependency>
  <groupId>org.terems</groupId>
  <artifactId>webz-api</artifactId>
  <version>0.9.1-SNAPSHOT</version>
</dependency>
```

**NOTE:** currently you also need to specify Sonatype snapshots repository (either in your **pom.xml** or in your global **settings.xml**):
```
<repositories>
  ...
  <repository>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
    <id>snapshots-sonatype</id>
    <name>snapshot</name>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
  </repository>
</repositories>
```
After version* ***0.9.1*** *(Pedesis beta) is released the need to specify Sonatype snapshots repository will be eliminated...
