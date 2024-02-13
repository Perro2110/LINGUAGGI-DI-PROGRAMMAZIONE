i = input("inserisci numero ")
print("numero inserito:",i)
s = "a: {} b: {}"
x=1
y=2
z=9
print(s.format(x,y,z))

matrix = [ [1, 2, 3, 4],[5, 6, 7, 8],[9, 10, 11, 12]]

print(matrix)

print([ [ row[i] for row in matrix ] for i in range(4) ])


r=[]
r2=[]

for i in range(len (matrix[0])):
    r.append([])

for row in matrix:
    for i in range(len(row)):
        r[i].append(row[i])


for j in range(len(matrix[0])):
    r2.append([])
    for i in range(len(matrix)):
        r2[j].append(matrix[i][j])

print(r)
print(r2)

a=[]
## del a
print(a)

vet= []
for x in range (6):
    vet.append(x+2)

sum = 0

for x in vet:
    sum=sum+x

print(vet)
print(sum)

i=0
sum=0
for x in vet:
    sum=sum+x
    vet[i]=sum
    i=i+1

print(vet)

from numpy import array

sum=0
due=2
nvet = array(range(6))
nvet = nvet + due
print(nvet)

print(nvet.sum())
for x in nvet:
    sum=sum + x

print(sum)

sum = 0
i=0
for x in nvet:
    sum = sum + x
    nvet[i]=sum
    i=i+1

print(nvet)

a = {x for x in "abracadabra" if x not in "abc"}
print(a)

dictt={'Boss Nass':'Star Wars','Tom Bombadil':'The Lord of the Rings','Hari Seldon':'Foundation series','Polliver':'Game of Thrones','Jules Winnfield':'Pulp Fiction','The Mule':'Foundation series','Flynn Rider':'Rapunzel','Yoda':'Star Wars','Vince Vega':'Pulp Fiction'}
print(dictt)

print()

dictt2={}

for key in dictt:
    dictt2[dictt.get(key)]=[key2 for key2 in dictt.keys() if dictt.get(key2)==dictt.get(key)]

dictt3 = {}
print(dictt2)

for key,val in dictt2.items():
    for vall in val:
        dictt3[vall]=key


print()
print(dictt3)

###########################################################


def f(x=10):
    print(x)

f()
f(30)

def useless_f(x, y, n=5, s="boh"):
    print(x, y, n, s)

useless_f(1,2)
useless_f(1,2,3)
useless_f(1,2,3,4)

def f(a, L=[]):
    L.append(a)
    return L

print(f(1))
print(f(2))
print(f(69))

def f(a,L=None):
    if L is None:
        L = []
    L.append(a)
    return L

print(f(1))
print(f(2))
print(f(69))

def function_name(arg1,arg2,*argl,**argm):
    print(arg1)
    print(arg2)
    print(argl)
    print(argm)

function_name(1,2,3,4,6,7,val1=5,val2=6)

def f(x,y,*arl):
    print(x,y)

l=[1,2,32]
f(*l)

print(range(*l))

def f(x,y):
    '''
    va che bello
    '''
    print("x=",x,"y=",y)

m = {'y':1,'x':2}
f(**m)
#Assegnerà 2 a x e 1 a y.
help(f)

# This is how you declare the type of a variable
age: int = 1
# You don't need to initialize a variable to annotate it
a: int # Ok (no value at runtime until assigned)

child: bool
if age < 18:
    child = True
else:
    child = False

# For most types, just use the name of the type in the annotation
x: int = 1
x: float = 1.0
x: bool = True
x: str = "test"
x: bytes = b"test"

# For collections
x: list[int] = [1]
x: set[int] = {6, 7}

# For mappings, we need the types of both keys and values
x: dict[str, float] = {"field": 2.0} # Python 3.9+

# For tuples of fixed size, we specify the types of all the elements
x: tuple[int, str, float] = (3, "yes", 7.5) # Python 3.9+
# For tuples of variable size, we use one type and ellipsis
x: tuple[int, ...] = (1, 2, 3) # Python 3.9+

# On Python 3.10+, use the | operator when something could be one of a few types
x: list[int | str] = [3, 5, "test", "fun"] # Python 3.10+

# This is how you annotate a function definition
def stringify(num: int) -> str:
    return str(num)

# And here's how you specify multiple arguments
def plus(num1: int, num2: int) -> int:
    return num1 + num2

# If a function does not return a value, use None as the return type
# Default value for an argument goes after the type annotation
def show(value: str, excitement: int = 10) -> None:
    print(value + "!" * excitement)

#####################################################################
#####################################################################
import moduloPrimo

moduloPrimo.function_name(3)

# Per importare solo le funzioni fn_name1 e fn_name2
from a import f, f2

from b import *

