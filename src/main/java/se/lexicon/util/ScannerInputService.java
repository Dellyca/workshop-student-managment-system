package se.lexicon.util;

import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {

    private Scanner scanner;

    @Override
    public String getString() {
        return scanner.next();
    }

    @Override
    public int getInt() {
        return scanner.nextInt();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
