class Vehicle:
    '''
    attributi speed ed acceleration
    '''
    speed: float
    acceleration: float
    def __init__(self,speed=0.0,acceleration=0.0) -> None:
        self.speed = speed
        self.acceleration=acceleration

    def set_speed(self,speed) -> None:
        if(isinstance(speed, str)):
            self.speed = float(speed)
        self.speed = speed

    def set_acceleration(self,acceleration) -> None:
        if(isinstance(acceleration, str)):
            self.acceleration = float(acceleration)
        self.acceleration = acceleration

    def print_speed(self) -> None:
        print(self.speed)

    def print_acceleration(self) -> None:
        print(self.acceleration)

    @staticmethod
    def  compute_speed_increment(acc:float,sec:int) -> float:
        return acc*sec
    
class Car(Vehicle):

    plate : str
    running : bool

    def __init__(self,plate,running=False,speed=0.0,acceleration=0.0):
        super().__init__(speed,acceleration)
        self.plate=plate
        self.running=running
        if(running==False):
            speed=0
            acceleration=0

        
    def start(self) -> None:
        self.running = True
    
    def stop(self) -> None:
        self.running = False
        self.set_acceleration(0.0)
        self.set_speed(0.0)

    def  accelerate(self,accelerazione: float,secondi :int) -> None:
        if(self.running):
            self.speed=self.speed+self.compute_speed_increment(accelerazione,secondi)

    @staticmethod
    def print_n_wheels() -> None:
        print(4)
   
class Bicycle(Vehicle):

    def __init__(self,speed=0.0,acceleration=0.0):
        super().__init__(speed,acceleration)

        
    def pedal(self,n_hits:int,secondi:int) -> None:
        self.acceleration=n_hits/secondi**2
        self.speed= self.compute_speed_increment(self.acceleration,secondi)
  
    @staticmethod
    def print_n_wheels() -> None:
        print(2)

if __name__ == "__main__":
    c = Car('ABC',False,10,11)
    b = Bicycle('10.1','0')
    Car.print_n_wheels()
    b.print_n_wheels()
    b.set_speed(5)
    c.set_acceleration(1)
    print(" - Car c ----------")
    c.print_speed()
    c.print_acceleration()
    print("\n\n - Bicycle b ------")
    b.print_speed()
    b.print_acceleration()
    print(" ------------------")
    c.start()
    c.accelerate(10.1,2)
    b.pedal(2,5)
    print(" - Car c ----------")
    c.print_speed()
    c.print_acceleration()
    print("\n\n - Bicycle b ------")
    b.print_speed()
    b.print_acceleration()
    print(" ------------------")
    c.stop()
    print(" - Car c ----------")
    c.print_speed()
    c.print_acceleration()
    print("\n\n - Bicycle b ------\n")
    b.print_speed()
    b.print_acceleration()
    print(" ------------------\n")

