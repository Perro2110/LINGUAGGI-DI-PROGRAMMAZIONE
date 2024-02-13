import sys
import argparse

from Impiegati import Impiegati 
from Sommelier import Sommelier 
from Guida import Guida 
from Visitatori import Visitatori 
from Servizi import Servizi

class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        impiegati      = []
        visitatori     = []
        codNome        = {}
        codCostoOrario = {}
        CodVolte       = {}

        try:
            f=open("impiegati.txt","r")
            line = f.readline().strip()
            while(line != ''):
                tok  = line.split()
                cod  = int(tok[0])
                tipo = str(tok[1])
                line = f.readline().strip()
                nome = line
                if(tipo == "guida"):
                    line = f.readline().strip()
                    tok = line.split()
                    telefono = int(tok[0])
                    conoscenzaInglese = str(tok[1])
                    appuntamentiSettimanali = int(tok[2])
                    costoorario = float(tok[3])
                    i = Guida(cod, tipo, nome, costoorario,telefono,conoscenzaInglese,appuntamentiSettimanali)
                if(tipo == "sommelier"):
                    line = f.readline().strip()
                    tok = line.split()  
                    oreSettimanali = int(tok[0])      
                    costoorario    = float(tok[1])
                    line = f.readline().strip()   
                    specialita = line
                    i = Sommelier(cod, tipo,nome,costoorario,oreSettimanali,specialita)       
                impiegati.append(i)
                codNome[cod] = nome 
                codCostoOrario[cod] = costoorario
                CodVolte      [cod] = 0
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e) 

        try:
            f=open("visitatori.txt","r")
            line = f.readline().strip()
            while(line != ''):
                cod = line
                line = f.readline().strip()
                nome = line
                line = f.readline().strip()
                v = Visitatori(cod,nome)
                while(line != ''):
                    tok = line.split()
                    codice = int(tok[0])
                    numOre = float(tok[1])
                    CodVolte[codice] = CodVolte[codice] + 1
                    s = Servizi(codice,numOre,codCostoOrario[codice]*numOre,codNome[codice])
                    line = f.readline().strip()
                    v.addServizio(s)
                visitatori.append(v)
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)       

        print("nome, codice, tipo, ore settimanali, specialità, telefono,inglese, app.sett.,costo orario")
        for i in impiegati:
            print(i)

        for v in visitatori:
            print(v)
        
        cc=input("inserire codice: ")
        print(str(CodVolte[int(cc)]))
        

if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()