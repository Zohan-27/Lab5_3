import java.util.Scanner;

interface Displayable {
    void displayInfo();
}
abstract class Visualization implements Displayable {
    private int width;
    protected int height;
    String backgroundColor;
    public boolean isInteractive;

    public Visualization(int width, int height, String backgroundColor, boolean isInteractive) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.isInteractive = isInteractive;
    }

    public int getWidth() {
        return width;
    }
}

class VisualizationFrame extends Visualization {
    private String frameType;
    protected boolean isResizable;
    public int zIndex;

    public VisualizationFrame(int width, int height, String backgroundColor, boolean isInteractive,
                              String frameType, boolean isResizable, int zIndex) {
        super(width, height, backgroundColor, isInteractive);
        this.frameType = frameType;
        this.isResizable = isResizable;
        this.zIndex = zIndex;
    }

    @Override
    public void displayInfo() {
        System.out.println("VisualizationFrame Info:");
        System.out.println("Width: " + getWidth());
        System.out.println("Height: " + height);
        System.out.println("Background Color: " + backgroundColor);
        System.out.println("Interactive?: " + isInteractive);
        System.out.println("Frame Type: " + frameType);
        System.out.println("Resizable?: " + isResizable);
        System.out.println("Z-Index: " + zIndex);
    }
}

class VisualizationLayer extends Visualization {
    private String layerName;
    protected int opacity;
    public boolean isVisible;

    public VisualizationLayer(int width, int height, String backgroundColor, boolean isInteractive,
                              String layerName, int opacity, boolean isVisible) {
        super(width, height, backgroundColor, isInteractive);
        this.layerName = layerName;
        this.opacity = opacity;
        this.isVisible = isVisible;
    }

    @Override
    public void displayInfo() {
        System.out.println("VisualizationLayer Info:");
        System.out.println("Width: " + getWidth());
        System.out.println("Height: " + height);
        System.out.println("Background Color: " + backgroundColor);
        System.out.println("Interactive?: " + isInteractive);
        System.out.println("Layer Name: " + layerName);
        System.out.println("Opacity: " + opacity);
        System.out.println("Visible?: " + isVisible);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueInput = true;

        while (continueInput) {
            Visualization[] visualizations = new Visualization[3];
            VisualizationFrame[] frames = new VisualizationFrame[3];
            VisualizationLayer[] layers = new VisualizationLayer[3];

            for (int i = 0; i < 3; i++) {
                System.out.println("Enter Visualization " + (i + 1) + " data:");
                System.out.print("Width: ");
                int width = scanner.nextInt();
                System.out.print("Height: ");
                int height = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Background Color: ");
                String backgroundColor = scanner.nextLine();
                System.out.print("Interactive visualization (true/false): ");
                boolean isInteractive = scanner.nextBoolean();

                visualizations[i] = new VisualizationFrame(width, height, backgroundColor, isInteractive,
                        "Type", true, 1); // Предполагается использование VisualizationFrame

                System.out.println("\nEnter VisualizationLayer " + (i + 1) + " data:");
                System.out.print("Layer Name: ");
                String layerName = scanner.next();
                System.out.print("Opacity: ");
                int opacity = scanner.nextInt();
                System.out.print("Visible (true/false): ");
                boolean isVisible = scanner.nextBoolean();

                layers[i] = new VisualizationLayer(width, height, backgroundColor, isInteractive,
                        layerName, opacity, isVisible);

                scanner.nextLine();
                System.out.println();

                System.out.println("Do you want to continue entering data? (yes/no)");
                String choice = scanner.next();

                if (choice.equalsIgnoreCase("no")) {
                    continueInput = false;
                    break;
                } else if (!choice.equalsIgnoreCase("yes")) {
                    System.out.println("Invalid input. Continuing data entry by default.");
                }
                scanner.nextLine();
            }

            for (int i = 0; i < 3; i++) {
                if(visualizations[i] == null || layers[i] == null) {
                    break;
                }
                System.out.println("\nVisualization " + (i + 1) + " Info:");
                visualizations[i].displayInfo();
                System.out.println("\nVisualizationLayer " + (i + 1) + " Info:");
                layers[i].displayInfo();
            }
        }

        scanner.close();
    }
}
