Feature: US002 BlueRentalCar Excel Login

  Scenario: TC01 Pozitif Login Testi
    Given kullanici "blueRentalUrl" sayfasina properties ile gider
    And kullanici login butonuna tiklar
    But kullanici 2 saniye bekler
    And kullanici exceldeki "admin_info" sayfasindaki bilgiler ile giris yapip giris yapildigini test eder
    And sayfayi kapatir

