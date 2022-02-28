package org.saulesmeita.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Builds a simple text menu for a console application.
 * <p>
 * Usage:
 * {@code
 * var menu = new MenuBuilder()
 *          .title("Menu Title")
 *          .add("Menu Item", () -> System.out.println("Hello, World!"))
 *          .build();
 * <p>
 * menu.run();
 * }
 */
public class MenuBuilder {
    record Command(String name, Runnable action) {
    }

    private static final Scanner scanner = new Scanner(System.in);
    private final List<Command> menu = new ArrayList<>();
    private String title;
    private boolean isOneTime;

    public MenuBuilder title(String title) {
        this.title = '\n' + title + '\n';
        return this;
    }

    public MenuBuilder oneTime() {
        isOneTime = true;
        return this;
    }

    public MenuBuilder add(final String entry, final Runnable action) {
        menu.add(new Command(menu.size() + 1 + ". " + entry, action));
        return this;
    }

    @SuppressWarnings("squid:S106")
    public Runnable build() {
        return () -> {
            do {
                System.out.println(title);
                menu.stream().map(Command::name).forEach(System.out::println);
                System.out.println("0. Exit");
                try {
                    int choice = Integer.parseInt(scanner.nextLine()) - 1;
                    if (choice == -1) {
                        return;
                    }
                    menu.get(choice).action().run();
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Please enter the number from 0 up to " + menu.size());
                }
            } while (!isOneTime);
        };
    }
}

