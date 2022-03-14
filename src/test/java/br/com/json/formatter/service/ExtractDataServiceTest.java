package br.com.json.formatter.service;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExtractDataServiceTest{

    private static String LINE1 = "0000000057                          Elidia Gulgowski IV00000006200000000004     100.02520210919";
    private static String LINE2 = "0000000071                               Everett Beahan00000007610000000005     1001.5020210702";

    @Test
    public void sendLineExtractDataLineOne(){
        ExtractDataService extractDataService = new ExtractDataService();

        assertThat("Elidia Gulgowski IV").isEqualTo(extractDataService.extractName(LINE1));
        assertThat(57).isEqualTo(extractDataService.extractUserId(LINE1));
        assertThat(620).isEqualTo(extractDataService.extractOrderId(LINE1));
        assertThat("2021-09-19").isEqualTo(extractDataService.extractOrderDate(LINE1).toString());
        assertThat(4).isEqualTo(extractDataService.extractProductId(LINE1));
        assertThat(100.025).isEqualTo(extractDataService.extractProductValue(LINE1));
    }

    @Test
    public void sendLineExtractDataLineTwo(){
        ExtractDataService extractDataService = new ExtractDataService();

        assertThat("Everett Beahan").isEqualTo(extractDataService.extractName(LINE2));
        assertThat(71).isEqualTo(extractDataService.extractUserId(LINE2));
        assertThat(761).isEqualTo(extractDataService.extractOrderId(LINE2));
        assertThat("2021-07-02").isEqualTo(extractDataService.extractOrderDate(LINE2).toString());
        assertThat(5).isEqualTo(extractDataService.extractProductId(LINE2));
        assertThat(1001.50).isEqualTo(extractDataService.extractProductValue(LINE2));
    }



}