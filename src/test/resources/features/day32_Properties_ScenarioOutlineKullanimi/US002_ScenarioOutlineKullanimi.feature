Feature: US002 Google Sayfasi Testi

  Scenario Outline: TC01 Arama Kutusunda Araclar Aratilir
    Given kullanici "googleUrl" sayfasina properties ile gider
    Then kullanici google arama kutusunda "<aranacakAraclar>" aratir
    And kullanici 2 saniye bekler
    And kullanici sayfa basliginin "<aranacakAraclar>" icerdigini test etti
    And sayfayi kapatir
    Examples:
      | aranacakAraclar |
      | volvo           |
      | ford            |
      | audi            |
      | mercedes        |

