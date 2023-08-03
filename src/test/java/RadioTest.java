import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    public void testSetCurrentStationRegular() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        int actual = radio.getCurrentStation();
        int expected = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetCurrentStationOver() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(10);
        int actual = radio.getCurrentStation();
        int expected = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetCurrentStationBellowZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(-1);
        int actual = radio.getCurrentStation();
        int expected = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNextRegular() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 6;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNextAfterNine() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevRegular() {
        Radio radio = new Radio();
        radio.setCurrentStation(6);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevAfterPreviousZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(34);
        int actual = radio.getCurrentVolume();
        int expected = 34;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetVolumeOver100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(34);
        radio.setCurrentVolume(101);
        int actual = radio.getCurrentVolume();
        int expected = 34;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetVolumeBellowZero() {
        Radio radio = new Radio();
        radio.setCurrentVolume(34);
        radio.setCurrentVolume(-1);
        int actual = radio.getCurrentVolume();
        int expected = 34;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIncreaseVolumeOver100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 100;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIncreaseVolumeRegular() {
        Radio radio = new Radio();
        radio.setCurrentVolume(34);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 35;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDecreaseVolumeBellowZero() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDecreaseVolumeRegular() {
        Radio radio = new Radio();
        radio.setCurrentVolume(34);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 33;
        Assertions.assertEquals(expected, actual);
    }
}