package com.hero.designpatten.memo.v2;

import java.util.Scanner;

/**
 * @description: ApplicationMain
 * @date: 2021/3/17 9:41
 * @author: maccura
 * @version: 1.0
 */
public class ApplicationMain {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotsHolder = new SnapshotHolder();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();

            if (":list".equals(input)) {
                System.out.println(inputText.getText());
            } else if (":undo".equals(input)) {
                SnapShot snapshot = snapshotsHolder.popSnapshot();
                inputText.restoreSnapshot(snapshot);
            } else {
                snapshotsHolder.pushSnapshot(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }
}
