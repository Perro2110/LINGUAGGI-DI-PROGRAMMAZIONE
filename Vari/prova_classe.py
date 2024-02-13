class Point:
    '''
    This is a 2-D point
    Attributes: x,y
    '''
    def __init__(self,x=0,y=0):
        self.x = x
        self.y = y

    def distance_from_origin(self):
        return ( ((self.x **2) + (self.y **2))**(1/2))



p1 = Point() # senza parametri in ingresso
p2 = Point(1) # passando x
p3 = Point(1, 2) # passando x ed y
p4 = Point(y = 2) # passando solo y

#
#E’ possible accedere ad un attributo utilizzando la notazione con il
#punto à p1.x
#

print(p1.x,p1.y)
print(p2.x,p2.y)
print(p3.x,p3.y)
print(p4.x,p4.y)

'''
Metodi Speciali

    • __ indica che il metodo è un metodo speciale.
    • Questo viene utilizzato per rendere la nostra classe più simile ad un tipo
    built-in di Python.

    • Per esempo:
    
    • __str__ è usato per stampare (converte lo stato di un oggetto in una stringa).
    • __cmp__ è usato per consentire l’uso di operazioni di confronto
    • __cmp__(self,other) restituisce -1 se self è “più piccolo” di other , 0 se
                          sono uguali e 1 altrimenti.
    • __eq__, __lt__, __gt__
    • __add__ è usato per consentire l’operazione +
    • __iter__ è usato per consentire al nuovo tipo di essere usato in un ciclo.
    • __doc__ restituisce una docstring
'''
