package com.academy.automationpractice.properties;

//import com.google.j2objc.annotations.Property;
import cucumber.runtime.io.Resource;
import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource.File;

@File("src/main/resources/automationpractice.properties")
//D:\autotesting\auto-projects\Academy-maven\src\main\resources\automationpractice.properties
public interface Properties {

    @Property("user1.login")
    String user1Login();

    @Property("user1.passw")
    String user1Passw();

    Properties props = PropertyLoader.newInstance().populate(Properties.class);
}
