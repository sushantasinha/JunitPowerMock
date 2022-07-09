Please refer JunitTutorials project for details


static method test: Nothing special, can do using normal junit only (mockito or powermock not needed)
static method mock: Power Mock using mockStatic()... (Mockito now allowing to mock, but there is no example i used)
Previous to version 3.4.0 of Mockito, it wasn't possible to mock static methods directly — only with the help of PowerMockito.
Now mockito is allowed to mock static method.



Private method test: Using power mock. Using Whitebox.invokeMethod(...)
Private method mock: Using power mock. Usig spy() and when().then() reflection.


final method test: Nothing special, can do using normal junit only (mockito or powermock not needed)
final method mock: (Mockito: Cannot mock final methods), need to use Power Mock (whenNew())
 
constructor mocking: Power Mock. Using whenNew()

Partial mocking possible for static, final and private methods. power mock can be used with @spy

Mocking for private method, static method and constructor is bad design.


### TODO: mutation test
### TODO: flapdrool


