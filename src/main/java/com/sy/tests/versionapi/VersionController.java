package com.sy.tests.versionapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
    @GetMapping("/ver")
    public VersionInfo version(){
        return readVersionInfoInManifest();
    }

    public VersionInfo readVersionInfoInManifest(){
        VersionInfo object = new VersionInfo();
        Package objPackage = object.getClass().getPackage();
        //examine the package object
        object.Name = objPackage.getSpecificationTitle();
        object.SpecificationVersion = objPackage.getSpecificationVersion();
        object.ImplementationVersion = objPackage.getImplementationVersion();
        object.Vendor = objPackage.getImplementationVendor();

        //some jars may use 'Implementation Version' entries in the manifest instead
        System.out.println("Package name: " + object.Name);
        System.out.println("Package specification version: " + object.SpecificationVersion);
        System.out.println("Package version: " + object.ImplementationVersion);
        System.out.println("Package vendor: " + object.Vendor);
        return object;
    }

//use BuildProperties with spring-boot-maven-plugin
    @Autowired
    BuildProperties buildProperties;

    @GetMapping("/buildinfo")
    public VersionInfo getBuildInfo(){
        VersionInfo ver = new VersionInfo();
        ver.Name = buildProperties.getName();
        // Artifact version
        ver.ArtifactVersion = buildProperties.getVersion();
// Date and Time of the build
        ver.ArtifactTime = buildProperties.getTime();
// Artifact ID from the pom file
        ver.ArtifactID = buildProperties.getArtifact();
// Group ID from the pom file
        ver.ArtifactGroup = buildProperties.getGroup();
        return ver;
    }

//    public void readVersionThroughProperties() throws IOException {
//        final Properties properties = new Properties();
//        properties.load(this.getClass().getClassLoader().getResourceAsStream("project.properties"));
//        System.out.println(properties.getProperty("foo.bar"));
//        System.out.println(properties.getProperty("version"));
//        System.out.println(properties.getProperty("artifactId"));
//    }

}
