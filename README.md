Filip, Domazetovski 196107

CONTROL FLOW GRAPH(CFG):


 ЦИКЛОМАТСКА КОМПЛЕКСНОСТ:
 Цикломатската комплексност на програмата може да се пресмета користејќи или бројот на региони во CFG, или како сума од бројот на команди како (if, for, loop etc) плус еден. Има 4 if и 2 for команди, што значи дека цикломатската комплексност е 4+2+1=7.
 
Тест случаеви според критериумот Every Branch: 
  За да обезбедиме тест случаи според критериумот Every Branch, треба да се осигураме дека секоја гранка на кодот е покриена со најмалку еден тест случај.

  Тест случај за задолжителни информации што недостасуваат (фрлање исклучок):
        Влез:  user = null, allUsers = [User1, User2]
        Очекуван излез: RuntimeException("Mandatory information missing!")

  Тест случај за поставување на корисничко име на епошта кога корисничкото име е нула:
        Влез: user = User(email="example@example.com"), allUsers = [User1, User2]
        Очекуван излез: user.getUsername() is equal to "example@example.com"
  Тест случај за постоечки корисник со иста епошта, но различно корисничко име:
        Влез: user = User(username="example", email="example@example.com"), allUsers = [User1(email="example@example.com", username="different")]
        Очекуван излез: same = 0

  Тест случај за постоечки корисник со иста епошта и корисничко име:
        Влез:  user = User(username="example", email="example@example.com"), allUsers = [User1(email="example@example.com", username="example")]
        Очекуван излез: same = 2

  Тест случај за лозинка која содржи корисничко име и должина помала од 8 (враќа неточно):
        Влез: user = User(username="example", email="example@example.com", password="example"), allUsers = [User1]
        Очекуван излез: false

  Тест случај за лозинка што содржи специјален знак и без празно место:
        Внесување: user = User(username="example", email="example@example.com", password="example!123"), allUsers = [User1]
        Очекуван излез: false

  Тест случај за лозинка што содржи специјален знак и празно место:
        Внесување: user = User(username="example", email="example@example.com", password="example! 123"), allUsers = [User1]
        Очекуван излез: same = 0

