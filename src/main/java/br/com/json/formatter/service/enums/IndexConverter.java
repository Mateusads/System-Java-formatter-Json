package br.com.json.formatter.service.enums;

public enum IndexConverter {

    INDEX_IDUSER_START(0), INDEX_IDUSER_END(10),
    INDEX_NAMEUSER_START(11), INDEX_NAMEUSER_END(55),
    INDEX_IDORDER_START(55), INDEX_IDORDER_END(65),
    INDEX_IDPRODUCT_START(65), INDEX_IDPRODUCT_END(75),
    INDEX_VALUEPRODUCT_START(75), INDEX_VALUEPRODUCT_END(87),
    INDEX_DATEORDER_START(87), INDEX_DATEORDER_END(95);

    private int value;

    private IndexConverter(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
