package com.hero.hanlp;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Demo
{
    public static void main( String[] args )
    {
        List<Term> termList = NLPTokenizer.segment("中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程");
        //termList = NLPTokenizer.segment("免疫产品I3000泵阀重启故障分析");
        System.out.println(termList);

    }
}
