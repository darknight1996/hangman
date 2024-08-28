package org.example.content;

import java.util.HashMap;
import java.util.Map;

public class HangmanContent {

    private final Map<Integer, Stage> errorsCountToStageMap;

    public HangmanContent() {
        errorsCountToStageMap = new HashMap<>();
        initMap();
    }

    private void initMap() {
        int errorsCount = 0;
        for (Stage stage: Stage.values()) {
            errorsCountToStageMap.put(errorsCount, stage);
            errorsCount++;
        }
    }

    public String getHangman(final int errorsCount) {
        return errorsCountToStageMap.get(errorsCount).getContent();
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

        Stage(final String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

}
