package example.co;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class PCConfiguratorController {

    // Pola ComboBox dla różnych komponentów PC
    private ComboBox<CPU> cpuComboBox;
    private ComboBox<PCComponent> airCpuCoolerComboBox;
    private ComboBox<PCComponent> liquidCpuCoolerComboBox;
    private ComboBox<PCComponent> caseFansComboBox;
    private ComboBox<Motherboard> motherboardComboBox;
    private ComboBox<PCComponent> ramComboBox;
    private ComboBox<PCComponent> graphicsCardComboBox;
    private ComboBox<PCComponent> ssdComboBox;
    private ComboBox<PSU> psuComboBox;

    public void setComboBoxes(ComboBox<PCComponent> airCpuCoolerComboBox,
                              ComboBox<PCComponent> liquidCpuCoolerComboBox,
                              ComboBox<PCComponent> caseFansComboBox,
                              ComboBox<PCComponent> ramComboBox,
                              ComboBox<PCComponent> graphicsCardComboBox,
                              ComboBox<PSU> psuComboBox,
                              ComboBox<PCComponent> ssdComboBox,
                              ComboBox<Motherboard> motherboardComboBox,
                              ComboBox<CPU> cpuComboBox) {
        // Ustawianie ComboBox dla różnych komponentów PC
        this.cpuComboBox = cpuComboBox;
        this.airCpuCoolerComboBox = airCpuCoolerComboBox;
        this.liquidCpuCoolerComboBox = liquidCpuCoolerComboBox;
        this.caseFansComboBox = caseFansComboBox;
        this.motherboardComboBox = motherboardComboBox;
        this.ramComboBox = ramComboBox;
        this.graphicsCardComboBox = graphicsCardComboBox;
        this.ssdComboBox = ssdComboBox;
        this.psuComboBox = psuComboBox;
    }

    public void updatePSUList() {
        // Obliczanie całkowitego TDP
        int totalTDP = calculateTotalTDP();
        ObservableList<PSU> originalPSUs = FXCollections.observableArrayList(psuComboBox.getItems());
        ObservableList<PSU> filteredPSUs = originalPSUs.filtered(psu -> psu.getPower() >= totalTDP);
        psuComboBox.setItems(filteredPSUs);
    }

    private int calculateTotalTDP() {
        // Obliczanie całkowitego TDP
        int totalTDP = 0;

        CPU selectedCPU = cpuComboBox.getSelectionModel().getSelectedItem();
        if (selectedCPU != null) {
            totalTDP += selectedCPU.getTDP();
        }

        PCComponent selectedGPU = graphicsCardComboBox.getSelectionModel().getSelectedItem();
        if (selectedGPU instanceof GPU) {
            totalTDP += ((GPU) selectedGPU).getTDP();
        }

        // Dodawanie 150 W
        totalTDP += 150;

        return totalTDP;
    }

    public void refreshPSUList() {
        // Odświeżanie listy zasilaczy
        updatePSUList();
    }

    // Obliczanie całkowitej ceny komponentów PC
    public double calculateTotalPrice() {
        double total = 0;
        total += cpuComboBox.getSelectionModel().getSelectedItem().getPrice();
        total += airCpuCoolerComboBox.getSelectionModel().getSelectedItem().getPrice();
        total += liquidCpuCoolerComboBox.getSelectionModel().getSelectedItem().getPrice();
        total += caseFansComboBox.getSelectionModel().getSelectedItem().getPrice();
        total += motherboardComboBox.getSelectionModel().getSelectedItem().getPrice();
        total += ramComboBox.getSelectionModel().getSelectedItem().getPrice();
        total += graphicsCardComboBox.getSelectionModel().getSelectedItem().getPrice();
        total += ssdComboBox.getSelectionModel().getSelectedItem().getPrice();
        total += psuComboBox.getSelectionModel().getSelectedItem().getPrice();

        return total;
    }

    // Zwracanie konfiguracji PC jako ciąg znaków
    public String getConfiguration() {
        return "Procesor: " + cpuComboBox.getSelectionModel().getSelectedItem().getName() + "\n" +
                "Chłodzenie CPU powietrzem: " + airCpuCoolerComboBox.getSelectionModel().getSelectedItem().getName() + "\n" +
                "Chłodzenie CPU cieczą: " + liquidCpuCoolerComboBox.getSelectionModel().getSelectedItem().getName() + "\n" +
                "Wentylatory obudowy: " + caseFansComboBox.getSelectionModel().getSelectedItem().getName() + "\n" +
                "Płyta główna: " + motherboardComboBox.getSelectionModel().getSelectedItem().getName() + "\n" +
                "RAM: " + ramComboBox.getSelectionModel().getSelectedItem().getName() + "\n" +
                "Karta graficzna: " + graphicsCardComboBox.getSelectionModel().getSelectedItem().getName() + "\n" +
                "SSD: " + ssdComboBox.getSelectionModel().getSelectedItem().getName() + "\n" +
                "Zasilacz: " + psuComboBox.getSelectionModel().getSelectedItem().getName() + "\n";
    }

    // Obliczanie oceny AnTuTu na podstawie ceny procesora i karty graficznej. Wiadomo że to oblicza się inaczej ale dla funkcjanalności :)
    public int calculateAntutuScore() {
        int score = 0;
        score += cpuComboBox.getSelectionModel().getSelectedItem().getPrice() * 10;
        score += graphicsCardComboBox.getSelectionModel().getSelectedItem().getPrice() * 10;
        score += ramComboBox.getSelectionModel().getSelectedItem().getPrice() * 10;
        return score;
    }
}
