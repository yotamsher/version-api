package com.sy.tests.versionapi;

import java.time.Instant;

public class VersionInfo {
    String ArtifactGroup;
    public String getArtifactGroup() { return this.ArtifactGroup;  }
    String ArtifactID;
    public String getArtifactID(){return this.ArtifactID; }
    String ArtifactVersion;
    public String getArtifactVersion() { return this.ArtifactVersion; }
    Instant ArtifactTime;
    public Instant getArtifactTime(){ return this.ArtifactTime; }
    String ImplementationVersion;
    public String getImplementationVersion() {
        return this.ImplementationVersion;
    }
    String SpecificationVersion;
    public String getSpecificationVersion(){
        return this.SpecificationVersion;
    }
    String Name;
    public String getName(){
        return this.Name;
    }
    String Vendor;
    public String getVendor(){
        return this.Vendor;
    }
}
