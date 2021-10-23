package com.sy.tests.versionapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Properties;
import java.util.jar.Manifest;

@RestController
public class VersionController {
    @GetMapping("/ver")
    public VersionInfo version(){
        return readVersionInfoInManifest(); }

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

//    public void readVersionThroughProperties() throws IOException {
//        final Properties properties = new Properties();
//        properties.load(this.getClass().getClassLoader().getResourceAsStream("project.properties"));
//        System.out.println(properties.getProperty("foo.bar"));
//        System.out.println(properties.getProperty("version"));
//        System.out.println(properties.getProperty("artifactId"));
//    }

}
