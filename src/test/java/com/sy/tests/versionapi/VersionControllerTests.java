package com.sy.tests.versionapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class VersionControllerTests {
    @Test
    void readVersionInfoInManifestWorks(){
        VersionController controller = new VersionController();
        var info =  controller.readVersionInfoInManifest();
        Assert.isNull(info.getImplementationVersion(), "version works");
    }
}
