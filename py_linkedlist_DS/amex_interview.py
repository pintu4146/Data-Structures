class Student: 
    def __init__(self, name):
        self.__name = name
        self._age = 20
s1 = Student("Volopo")
 
print(s1.__name) #-> Error
print(s1._age) #-> 20
print(s1._Student__name) #-> output?
print(s1._Student_age) #-> output?