package com.hero.designpatten.factory;

/**
 * @description: RuleConfigSource
 * @date: 2021/3/3 9:59
 * @author: maccura
 * @version: 1.0
 */
public class RuleConfigSource {
    private String getFileExtension(String filePath) {
        return "json";
    }

    private IRuleConfigParser createParserA(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }

    private IRuleConfigParser createParserB(String configFormat) {
        IRuleConfigParser parser = null;
        IRuleConfigParserFactory ruleConfigParserFactory = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            ruleConfigParserFactory = new JsonRuleConfigParserFactory();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            ruleConfigParserFactory = new XmlRuleConfigParserFactory();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            ruleConfigParserFactory = new YamlRuleConfigParserFactory();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            ruleConfigParserFactory = new PropertiesRuleConfigParserFactory();
        }

        //可能为空，异常暂不处理
        parser = ruleConfigParserFactory.createParser();
        return parser;
    }

    private IRuleConfigParser createParserC(String configFormat) {
        IRuleConfigParser parser = null;
        IRuleConfigParserFactory ruleConfigParserFactory = null;

        ruleConfigParserFactory = RuleConfigParserFactoryMap.getParserFactory(configFormat);
        //可能为空，异常暂不处理
        parser = ruleConfigParserFactory.createParser();
        return parser;
    }

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = null;

        parser = createParserA(ruleConfigFileExtension);
        if (parser == null) {
            throw new InvalidRuleConfigException(
                    "Rule config file format is not supported: " + ruleConfigFilePath);
        }

        //从ruleConfigFilePath文件中读取配置文本到configText中
        String configText = "";

        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }
}
