package com.pokeapi.poketest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.WsdlDefinition;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class WsdlConfig {

    @Bean(name = "abilities")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema abilitiesSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("AbilitiesPort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://pokeapi.com/poketest/soap");
        definition.setSchema(abilitiesSchema);
        return definition;
    }

    @Bean
    public XsdSchema abilitiesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/abilities.xsd"));
    }
}