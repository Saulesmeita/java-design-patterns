package org.saulesmeita.readability;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ShellComponent
public class AppShell {
    private TextStatistics textStatistics;

    @ShellMethod("Load text from file.")
    public String load(String file) throws IOException {
        textStatistics = TextStatistics.from(Files.readString(Path.of(file)));
        return "Text successfully loaded from " + file;
    }

    @ShellMethod("Print readability score for loaded file")
    public String score(@ShellOption(defaultValue="ALL")  String scoreName) {
        return Stream.of(ReadabilityScores.values())
                .filter(score -> score.isSelected(scoreName))
                .map(score -> score.getScoreAndAge(textStatistics))
                .collect(Collectors.joining("\n"));
    }

}
