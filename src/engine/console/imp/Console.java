package engine.console.imp;



import engine.console.IConsole;

import java.nio.BufferOverflowException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** Simple Implementation of Console. */
final class Console implements IConsole {

    private Scanner scanner;

    @Override
    public void open() {
        if (scanner != null) {
            throw new IllegalStateException("console already opened");
        }
        scanner = new Scanner(System.in);
    }

    @Override
    public void close() {
        if (scanner == null) {
            throw new IllegalStateException("console already closed");
        }
        scanner = null;
    }

    @Override
    public String readLine() {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException | IllegalStateException
            | IndexOutOfBoundsException | BufferOverflowException e) {
            return null;
        }
    }

}