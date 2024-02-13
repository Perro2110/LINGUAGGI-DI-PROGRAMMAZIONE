def f(x,y=10) -> int:
    return (x+y)

def g(x) -> int:
    return (x**3)

if __name__ == "__main__":
    a=f(2)
    b=f(g(2))
    print(a,b)
