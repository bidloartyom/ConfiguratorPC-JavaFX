package example.co;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PCConfiguratorUI  extends PCConfiguratorController {
    private BorderPane rootPane;
    private GridPane grid;
    private Label totalPriceLabel;
    private TextArea configurationTextArea;
    private Label antutuScoreLabel;
    private Tooltip descriptionTooltip;
    private PCConfiguratorController controller;

    public PCConfiguratorUI(PCConfiguratorController controller) {
        this.controller = controller;
        rootPane = new BorderPane();
        rootPane.getStyleClass().add("root");  // Добавляем класс стиля root

        grid = new GridPane();
        grid.getStyleClass().add("grid-pane");  // Добавляем класс стиля grid-pane

        descriptionTooltip = new Tooltip();

        ComboBox<CPU> cpuComboBox = new ComboBox<>();
        ObservableList<CPU> cpus = FXCollections.observableArrayList(
                new CPU("AMD Ryzen 3 3300X", 120, "4 rdzenie, 8 wątków, 3.8/4.3 GHz", "AM4", 65),
                new CPU("AMD Ryzen 5 5600X", 299, "6 rdzeni, 12 wątków, 3.7/4.6 GHz (bazowa/maksymalna)", "AM4", 65),
                new CPU("AMD Ryzen 7 5800X", 449, "8 rdzeni, 16 wątków, 3.8/4.7 GHz", "AM4", 105),
                new CPU("AMD Ryzen 9 5900X", 549, "12 rdzeni, 24 wątki, 3.7/4.8 GHz", "AM4", 105),
                new CPU("Intel Core i5-11600K", 269, "6 rdzeni, 12 wątków, 3.9/4.9 GHz", "LGA1200", 125),
                new CPU("Intel Core i7-11700K", 399, "8 rdzeni, 16 wątków, 3.6/5.0 GHz", "LGA1200", 125),
                new CPU("Intel Core i9-11900K", 539, "8 rdzeni, 16 wątków, 3.5/5.3 GHz", "LGA1200", 125)

        );

        ComboBox<PCComponent> airCpuCoolerComboBox = createComboBox(new PCComponent[]{
                new PCComponent("No Air Cooler", 0.00, "No additional air cooling."),
                new PCComponent("Cooler Master Hyper 212", 30.00, "Affordable and efficient air cooling."),
                new PCComponent("Cooler Master Hyper 212 EVO", 35, "Wentylator 120 mm, rurki cieplne z aluminium, obsługa różnych gniazd"),
                new PCComponent("Cooler Master Hyper 212 RGB Black Edition", 45, "Wentylator SF120R RGB 120 mm, rurki cieplne z aluminium, obsługa różnych gniazd"),
                new PCComponent("Arctic Freezer 34 eSports DUO", 45, "Dwa wentylatory P-fan 120 mm, rurki cieplne z miedzi, obsługa różnych gniazd"),
                new PCComponent("Scythe Mugen 5 Rev.B", 50, "Wentylator Kaze Flex 120 mm, wiele aluminiowych żeber, obsługa różnych gniazd"),
                new PCComponent("Noctua NH-D15", 90, "Dwa wentylatory NF-A15 140 mm, podwójna wieża, niklowane rurki cieplne, obsługa różnych gniazd"),
                new PCComponent("be quiet! Dark Rock Pro 4", 90, "Wentylatory Silent Wings 3 120 mm i 135 mm, podwójna wieża, pokrycie ceramiczne, obsługa różnych gniazd")
        });

        ComboBox<PCComponent> liquidCpuCoolerComboBox = createComboBox(new PCComponent[]{
                new PCComponent("No Liquid Cooler", 0.00, "No liquid cooling."),
                new PCComponent("Cooler Master MasterLiquid Lite 120", 60, "Radiator 120 mm, pompka o niskim profilu, ciche wentylatory, obsługa różnych gniazd"),
                new PCComponent("Corsair Hydro Series H60", 80, "Radiator 120 mm, ciche wentylatory, pompka o niskim profilu, łatwa instalacja, obsługa różnych gniazd"),
                new PCComponent("NZXT Kraken X53", 130, "Radiator 240 mm, pompka z podświetleniem RGB, ciche wentylatory Aer P 120 mm, programowalne podświetlenie, obsługa różnych gniazd"),
                new PCComponent("NZXT Kraken X63", 150, "Radiator 280 mm, pompka z podświetleniem RGB, ciche wentylatory Aer P 140 mm, programowalne podświetlenie, obsługa różnych gniazd"),
                new PCComponent("Corsair Hydro Series H100i RGB Platinum SE", 170, "Radiator 240 mm, dwa wentylatory z podświetleniem RGB, pompka z podświetleniem RGB, programowalne podświetlenie RGB, obsługa różnych gniazd"),
                new PCComponent("Corsair Hydro Series H150i PRO RGB", 180, "Radiator 360 mm, trzy wentylatory z podświetleniem RGB, pompka z podświetleniem RGB, programowalne podświetlenie RGB, obsługa różnych gniazd")
        });

        ComboBox<PCComponent> caseFansComboBox = createComboBox(new PCComponent[]{
                new PCComponent("No case Cooler", 0.00, "No case cooling."),
                new PCComponent("Cooler Master Hyper 212", 30, "Affordable and efficient air cooling"),
                new PCComponent("Cooler Master Hyper 212 EVO", 35, "Wentylator 120 mm, rurki cieplne z aluminium, obsługa różnych gniazd"),
                new PCComponent("Arctic Freezer 34 eSports DUO", 45, "Dwa wentylatory P-fan 120 mm, rurki cieplne z miedzi, obsługa różnych gniazd"),
                new PCComponent("Cooler Master Hyper 212 RGB Black Edition", 45, "Wentylator SF120R RGB 120 mm, rurki cieplne z aluminium, obsługa różnych gniazd"),
                new PCComponent("Scythe Mugen 5 Rev.B", 50, "Wentylator Kaze Flex 120 mm, wiele aluminiowych żeber, obsługa różnych gniazd"),
                new PCComponent("Noctua NH-D15", 90, "Dwa wentylatory NF-A15 140 mm, podwójna wieża, niklowane rurki cieplne, obsługa różnych gniazd"),
                new PCComponent("be quiet! Dark Rock Pro 4", 90, "Wentylatory Silent Wings 3 120 mm i 135 mm, podwójna wieża, pokrycie ceramiczne, obsługa różnych gniazd"),
                new PCComponent("Noctua NH-U12A", 100, "Dwa wentylatory NF-A12x25 120 mm, siedem rur cieplnych, kompaktowy design, obsługa różnych gniazd")
        });
        ComboBox<Motherboard> motherboardComboBox = new ComboBox<>();
        ObservableList<Motherboard> allMotherboards = FXCollections.observableArrayList(
                new Motherboard("Gigabyte B560M DS3H", 100, "Obsługa procesorów Intel 10th i 11th Gen, DDR4, M.2 NVMe, HDMI, DVI, mATX", "LGA1200"),
                new Motherboard("Gigabyte B450 AORUS ELITE", 110, "Obsługa procesorów AMD Ryzen 1000, 2000, 3000, DDR4, M.2 NVMe, HDMI, ATX", "AM4"),
                new Motherboard("MSI MAG B460 TOMAHAWK", 130, "Obsługa procesorów Intel 10th i 11th Gen, DDR4, M.2 NVMe, HDMI, DisplayPort, ATX", "LGA1200"),
                new Motherboard("ASUS TUF Gaming B550-PLUS", 150, "Obsługa procesorów AMD Ryzen 3000, 4000 G-Series, 5000, DDR4, PCIe 4.0, M.2 NVMe, HDMI, ATX", "AM4"),
                new Motherboard("ASRock Z590 Extreme", 250, "Obsługa procesorów Intel 10th i 11th Gen, DDR4, PCIe 4.0, M.2 NVMe, HDMI, DisplayPort, ATX", "LGA1200"),
                new Motherboard("MSI MAG X570 TOMAHAWK WIFI", 250, "Obsługa procesorów AMD Ryzen 2000, 3000, 5000, DDR4, PCIe 4.0, M.2 NVMe, HDMI, DisplayPort, ATX", "AM4")
        );

        ComboBox<PCComponent> ramComboBox = createComboBox(new PCComponent[]{
                new PCComponent("ADATA XPG Z1 8GB (1 x 8GB) DDR4-3000", 45, "Pamięć DDR4 ADATA XPG Z1 o pojemności 8 GB (1 x 8 GB), taktowaniu 3000 MHz"),
                new PCComponent("Corsair Vengeance LPX 8GB (1 x 8GB) DDR4-3200", 50, "Standardowa pamięć RAM DDR4 o pojemności 8 GB, taktowaniu 3200 MHz"),
                new PCComponent("Team T-Force Vulcan Z 16GB (2 x 8GB) DDR4-3200", 70, "Pamięć DDR4 Team T-Force Vulcan Z o pojemności 16 GB (2 x 8 GB), taktowaniu 3200 MHz"),
                new PCComponent("Crucial Ballistix 16GB (2 x 8GB) DDR4-3200", 75, "Pamięć DDR4 Ballistix o pojemności 16 GB (2 x 8 GB), taktowaniu 3200 MHz"),
                new PCComponent("G.Skill Ripjaws V Series 16GB (2 x 8GB) DDR4-3600", 80, "Pamięć DDR4 Ripjaws V Series o pojemności 16 GB (2 x 8 GB), taktowaniu 3600 MHz"),
                new PCComponent("Kingston HyperX Fury 32GB (2 x 16GB) DDR4-3200", 130, "Pamięć DDR4 Kingston HyperX Fury o pojemności 32 GB (2 x 16 GB), taktowaniu 3200 MHz"),
                new PCComponent("Corsair Vengeance RGB Pro 32GB (2 x 16GB) DDR4-3600", 150, "Pamięć DDR4 Corsair Vengeance RGB Pro o pojemności 32 GB (2 x 16 GB), taktowaniu 3600 MHz")
        });

        ComboBox<PCComponent> graphicsCardComboBox = createComboBox(new GPU[]{
                new GPU("NVIDIA GeForce RTX 3060", 329, "12 GB GDDR6, 3584 CUDA cores, 1.32/1.78 GHz (base/boost), PCIe 4.0", 170),
                new GPU("NVIDIA GeForce RTX 3060 Ti", 399, "8 GB GDDR6, 4864 CUDA cores, 1.41/1.67 GHz (base/boost), PCIe 4.0", 200),
                new GPU("AMD Radeon RX 6700 XT", 479, "12 GB GDDR6, 2560 Stream Processors, 2.32/2.58 GHz (base/boost), PCIe 4.0", 230),
                new GPU("NVIDIA GeForce RTX 3070", 499, "8 GB GDDR6, 5888 CUDA cores, 1.50/1.73 GHz (base/boost), PCIe 4.0", 220),
                new GPU("AMD Radeon RX 6800 XT", 649, "16 GB GDDR6, 4608 Stream Processors, 2.01/2.25 GHz (base/boost), PCIe 4.0", 300),
                new GPU("NVIDIA GeForce RTX 3080", 699, "10 GB GDDR6X, 8704 CUDA cores, 1.44/1.71 GHz (base/boost), PCIe 4.0", 320),
                new GPU("NVIDIA GeForce RTX 3080 Ti", 1199, "12 GB GDDR6X, 10240 CUDA cores, 1.37/1.67 GHz (base/boost), PCIe 4.0", 350),
                new GPU("NVIDIA GeForce RTX 3090", 1499, "24 GB GDDR6X, 10496 CUDA cores, 1.40/1.70 GHz (base/boost), PCIe 4.0", 350)
        });
        ComboBox<PSU> psuComboBox = new ComboBox<>();
        ObservableList<PSU> psuOptions = FXCollections.observableArrayList(
                new PSU("Corsair CX550M", 60, "550W, 80 Plus Bronze, semi-modular", 550),
                new PSU("EVGA SuperNOVA 650 G5", 90, "650W, 80 Plus Gold, fully modular", 650),
                new PSU("Seasonic Focus GX-750", 110, "750W, 80 Plus Gold, fully modular", 750),
                new PSU("Corsair RM850x", 130, "850W, 80 Plus Gold, fully modular", 850),
                new PSU("EVGA SuperNOVA 1000 G5", 180, "1000W, 80 Plus Gold, fully modular", 1000),
                new PSU("Seasonic PRIME Ultra 1300W", 250, "1300W, 80 Plus Platinum, fully modular", 80),
                new PSU("Corsair AX1600i", 450, "1600W, 80 Plus Titanium, fully modular", 1600),
                new PSU("EVGA SuperNOVA 2000 T2", 500, "2000W, 80 Plus Titanium, fully modular", 2000)
        );
        psuComboBox.setItems(psuOptions);
        ComboBox<PCComponent> ssdComboBox = createComboBox(new PCComponent[]{
                new PCComponent("Samsung 970 EVO Plus 500GB", 89, "NVMe M.2, 3500/3200 MB/s (read/write)"),
                new PCComponent("Western Digital Blue SN550 1TB", 99, "NVMe M.2, 2400/1950 MB/s (read/write)"),
                new PCComponent("Crucial P3 1TB", 105, "NVMe M.2, 3500/3000 MB/s (read/write)"),
                new PCComponent("Kingston A2000 1TB", 115, "NVMe M.2, 2200/2000 MB/s (read/write)"),
                new PCComponent("Sabrent Rocket 4.0 1TB", 149, "NVMe M.2, 5000/4400 MB/s (read/write)"),
                new PCComponent("Samsung 980 Pro 1TB", 179, "NVMe M.2, 7000/5000 MB/s (read/write)"),
                new PCComponent("WD Black SN850 1TB", 189, "NVMe M.2, 7000/5300 MB/s (read/write)"),
                new PCComponent("Seagate FireCuda 530 1TB", 229, "NVMe M.2, 7300/6000 MB/s (read/write)")
        });

        cpuComboBox.setItems(cpus);
        motherboardComboBox.setItems(allMotherboards);
        //filtracja motherboards dla procesorów z podanym socketem
        motherboardComboBox.setOnAction(event -> {
            CPU selectedCPU = cpuComboBox.getSelectionModel().getSelectedItem();
            if (selectedCPU != null) {
                filterMotherboards(motherboardComboBox, allMotherboards, selectedCPU.getSocket());
            }
        });
        controller.setComboBoxes(
                airCpuCoolerComboBox,
                liquidCpuCoolerComboBox,
                caseFansComboBox,
                ramComboBox,
                graphicsCardComboBox,
                psuComboBox,
                ssdComboBox,
                motherboardComboBox,
                cpuComboBox
        );

        cpuComboBox.setOnAction(event -> controller.refreshPSUList());
        graphicsCardComboBox.setOnAction(event -> controller.refreshPSUList());
        addDescriptionToolTip(cpuComboBox);
        addDescriptionToolTip(airCpuCoolerComboBox);
        addDescriptionToolTip(liquidCpuCoolerComboBox);
        addDescriptionToolTip(caseFansComboBox);
        addDescriptionToolTip(ramComboBox);
        addDescriptionToolTip(graphicsCardComboBox);
        addDescriptionToolTip(psuComboBox);
        addDescriptionToolTip(ssdComboBox);
        addDescriptionToolTip(motherboardComboBox);

        grid.add(new Label("CPU:"), 0, 0);
        grid.add(cpuComboBox, 1, 0);
        grid.add(new Label("Air CPU Cooler:"), 0, 1);
        grid.add(airCpuCoolerComboBox, 1, 1);
        grid.add(new Label("Liquid CPU Cooler:"), 0, 2);
        grid.add(liquidCpuCoolerComboBox, 1, 2);
        grid.add(new Label("Case Fans:"), 0, 3);
        grid.add(caseFansComboBox, 1, 3);
        grid.add(new Label("Motherboard:"), 0, 4);
        grid.add(motherboardComboBox, 1, 4);
        grid.add(new Label("RAM:"), 0, 5);
        grid.add(ramComboBox, 1, 5);
        grid.add(new Label("Graphics Card:"), 0, 6);
        grid.add(graphicsCardComboBox, 1, 6);
        grid.add(new Label("SSD:"), 0, 7);
        grid.add(ssdComboBox, 1, 7);
        grid.add(new Label("PSU:"), 0, 8);
        grid.add(psuComboBox, 1, 8);

        totalPriceLabel = new Label("Total Price: £0.00");
        grid.add(totalPriceLabel, 1, 11);

        configurationTextArea = new TextArea();
        configurationTextArea.getStyleClass().add("text-area");  // Добавляем класс стиля text-area
        configurationTextArea.setEditable(false);
        configurationTextArea.setPrefRowCount(10);
        grid.add(configurationTextArea, 1, 9);

        antutuScoreLabel = new Label("AnTuTu Score: 0");
        grid.add(antutuScoreLabel, 1, 10);


        ToolBar toolBar = createToolBar();
        toolBar.getStyleClass().add("tool-bar");  // Добавляем класс стиля tool-bar
        rootPane.setTop(toolBar);
        rootPane.setCenter(grid);
    }

    public BorderPane getRootPane() {
        return rootPane;
    }

    private ComboBox<PCComponent> createComboBox(PCComponent[] components) {
        ComboBox<PCComponent> comboBox = new ComboBox<>();
        comboBox.getStyleClass().add("combo-box");
        comboBox.getItems().addAll(components);
        // Создаем новый Tooltip для каждого ComboBox
        Tooltip descriptionTooltip = new Tooltip();
        comboBox.setTooltip(descriptionTooltip);
        comboBox.setCellFactory(lv -> {
            ListCell<PCComponent> cell = new ListCell<>() {
                @Override
                protected void updateItem(PCComponent item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                }
            };

            cell.setOnMouseEntered(event -> {
                if (cell.getItem() != null) {
                    descriptionTooltip.setText(cell.getItem().getDescription());
                    descriptionTooltip.show(cell, event.getScreenX(), event.getScreenY() + 10);
                }
            });

            cell.setOnMouseExited(event -> descriptionTooltip.hide());

            return cell;
        });

        return comboBox;
    }

    // В классе PCConfiguratorUI
    private <T extends PCComponent> void addDescriptionToolTip(ComboBox<T> comboBox) {
        Tooltip descriptionTooltip = new Tooltip();
        comboBox.setTooltip(descriptionTooltip);
        comboBox.setCellFactory(lv -> {
            ListCell<T> cell = new ListCell<>() {
                @Override
                protected void updateItem(T item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getName()); // Отображаем название элемента
                    }
                }
            };

            cell.setOnMouseEntered(event -> {
                if (cell.getItem() != null) {
                    descriptionTooltip.setText(cell.getItem().getDescription()); // Показываем описание при наведении
                    descriptionTooltip.show(cell, event.getScreenX(), event.getScreenY() + 10);
                }
            });

            cell.setOnMouseExited(event -> descriptionTooltip.hide());

            return cell;
        });

        comboBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName()); // Отображаем название в поле ввода
                }
            }
        });
    }

    private void filterMotherboards(ComboBox<Motherboard> motherboardComboBox, ObservableList<Motherboard> allMotherboards, String socket) {
        ObservableList<Motherboard> filteredMotherboards = FXCollections.observableArrayList();
        for (Motherboard motherboard : allMotherboards) {
            if (motherboard.getSocket().equals(socket)) {
                filteredMotherboards.add(motherboard);
            }
        }
        motherboardComboBox.setItems(filteredMotherboards);
        motherboardComboBox.getSelectionModel();
    }

    private ToolBar createToolBar() {
        ToolBar toolBar = new ToolBar();
        Button ConfigurateButton = new Button("Configurate");
        ConfigurateButton.getStyleClass().add("button");
        ConfigurateButton.setOnAction(event -> {
            totalPriceLabel.setText("Total Price: £" + controller.calculateTotalPrice());
            configurationTextArea.setText(controller.getConfiguration());
            antutuScoreLabel.setText("AnTuTu Score: " + controller.calculateAntutuScore());
        });

        toolBar.getItems().addAll(ConfigurateButton);

        return toolBar;
    }
}
