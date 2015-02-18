# WebZ API v0.9 beta ([Pedesis](https://www.pinterest.com/teremterem/pedesis-from-ancient-greek-a-leaping/))

### WebZ API serves two purposes:
 1. At one hand it lets new WebZ Filters be developed and then plugged into [WebZ Server](https://github.com/terems-org/webz-server#webz-server-v09-beta-pedesis) in order to have some custom server side java logic in place.
 1. At the other hand it also allows the server to be extended at the other end - custom file sources can be implemented: for ex. adapters for external storages like Dropbox, adapters for SCM providers like GitHub (Git adapters) or even some "synthetic" file sources the data for which may originally not be structured as a file tree.

How To Use
------

Add this maven dependency to your pom.xml:
```
<dependency>
  <groupId>org.terems</groupId>
  <artifactId>webz-api</artifactId>
  <version>0.9.PEDESIS-SNAPSHOT</version>
</dependency>
```

**NOTE:** currently you also need to add the following (either to your pom.xml or to your global setting.xml):
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
**P.S.** Soon enough version **0.9.1.1** (Pedesis beta) will be released and the need to specify Sonatype snapshots repository will be eliminated.
