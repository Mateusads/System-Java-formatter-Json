package br.com.json.formatter.service;

import br.com.json.formatter.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadingFileServiceTest {

    @Test
    public void readFileReturnLine() {
        List<User> listUser = new ArrayList<>();
        ReadingFileService readFile = new ReadingFileService();
        var linesFile = readFile.readingFile("./src/fileDataTest.txt");
        linesFile.forEach(user -> listUser.add((User) user));

        assertThat(71).isEqualTo(listUser.get(0).getId());
        assertThat("Everett Beahan").isEqualTo(listUser.get(0).getName());
        assertThat(57).isEqualTo(listUser.get(1).getId());
        assertThat("Elidia Gulgowski IV").isEqualTo(listUser.get(1).getName());
    }
}