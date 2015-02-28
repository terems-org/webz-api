# WebZ API v0.9 beta ([Pedesis](https://www.pinterest.com/terems_org/pedesis-from-ancient-greek-a-leaping/))

WebZ API lets new **WebZ Filters** be developed and then plugged into [WebZ Server](https://github.com/terems-org/webz-server) in order to have some custom server side java logic in place.

> ***ATTENTION!*** *Right now the only way to extend WebZ Server with custom WebZ Filters is to package your code together with the server, and the moment you do this your code will automatically become "contaminated" by GNU Affero GPL.*
>
> *Some time later in order to resolve this problem it will become possible to supply custom WebZ Filters to the server as "user input" (WebZ Server will be picking up your custom WebZ Filters directly from your WebZ site/SPA repos).*

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

**NOTE:** Currently you also need to specify Sonatype snapshots repository (either in your **pom.xml** or in your global **settings.xml**):
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
> *When version* ***0.9.1*** *(Pedesis beta) comes out the artifact will be officially released at Sonatype and then you will not need to explicitly reference any external repositories...*
