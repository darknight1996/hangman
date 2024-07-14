package org.example.render;

import org.example.model.HiddenWord;

import java.util.HashMap;
import java.util.Map;

public class HangmanRenderer {

    private final Map<Integer, Stage> errorsCountToStageMap;
    private final HiddenWord hiddenWord;

    public HangmanRenderer(HiddenWord hiddenWord) {
        this.hiddenWord = hiddenWord;
        errorsCountToStageMap = new HashMap<>();

        int errorsCount = 0;
        for (Stage stage: Stage.values()) {
            errorsCountToStageMap.put(errorsCount, stage);
            errorsCount++;
        }
    }

    public void render() {
        System.out.println(errorsCountToStageMap.get(hiddenWord.getWrongChars().size()).getContent());
    }

    public enum Stage {
        ZERO("""
        ______
        |/   |
        |
        |
        |
        |"""),
        ONE("""
        ______
        |/   |
        |   ()
        |
        |
        |"""),
        TWO("""
        ______
        |/   |
        |   ()
        |   []
        |
        |"""),
        THREE("""
        ______
        |/   |
        |   ()
        |  /[]
        |
        |"""),
        FOUR("""
        ______
        |/   |
        |   ()
        |  /[]\\
        |
        |"""),
        FIVE("""
        ______
        |/   |
        |   ()
        |  /[]\\
        |   |
        |"""),
        SIX("""
        ______
        |/   |
        |   ()
        |  /[]\\
        |   ||
        |"""),;

        private final String content;

        Stage(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }
}
