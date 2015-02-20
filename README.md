# WebZ API v0.9 beta ([Pedesis](https://www.pinterest.com/teremterem/pedesis-from-ancient-greek-a-leaping/))

WebZ API serves two purposes:
 1. At one hand it lets new WebZ Filters be developed and then plugged into [WebZ Server](https://github.com/terems-org/webz-server#webz-server-v09-beta-pedesis) in order to have some custom server side java logic in place.
 1. At the other hand it also allows the server to be extended at the other end - custom file sources can be implemented: for ex. adapters for external storages like Dropbox, adapters for SCM providers like GitHub (Git adapters) or even some "synthetic" file sources the data for which may originally not be structured as a file tree.

> ***ATTENTION! Unlike WebZ API, WebZ Server itself is licensed under GNU Affero GPL v3.0*** *and right now the only way to extend WebZ Server in any way (including custom WebZ Filters) is to package the extensions together with the server, which will automatically make them "contaminated" with Affero GPL.*

*Later on (hopefully starting from the release of v0.9.1) certain levels of flexibility will be introduced - certain types of extensions will become possible without affecting the server's package.*

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

**NOTE:** currently you also need to add the following declaration (either to your **pom.xml** or to your global **settings.xml**):
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
*Soon enough version* ***0.9.1*** *(Pedesis beta) will be released and the need to specify Sonatype snapshots repository will be eliminated...*
