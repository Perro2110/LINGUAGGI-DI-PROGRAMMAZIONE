class Servizi:
    def __init__(self,cod,numOre,costo,nome) -> None:
        self.cod    = cod
        self.numOre = numOre
        self.costo  = costo
        self.nome   = nome

    def __str__(self) -> str:
        return self.nome+" " + str(self.numOre)+" "+ str(self.costo)
