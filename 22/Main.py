# 16.02 
# 17.00
import sys
import argparse

from Corsi import Corsi
from Teoria import Teoria
from Laboratorio import Laboratorio
from Studenti import Studenti
from CorsiSeguiti import CorsiSeguiti

class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        corsi    = []
        studenti = []
        CodNome  = {}
        try:
            f=open("corsi.txt","r")
            line = f.readline().strip()
            while(line != ''):
                tok  = line.split()
                cod  = int(tok[0])
                tipo = str(tok[1])
                line = f.readline().strip()
                nomeDelCorso = line
                line = f.readline().strip()
                nomeECognomeDocente = line
                if(tipo == "teoria"):
                    line = f.readline().strip()
                    tok  = line.split()
                    codAula = int(tok[0])
                    numeroOreSettimanali = int(tok[1])
                    numeroOrePerLezione = float(tok[2])
                    c = Teoria (cod, tipo, nomeDelCorso,nomeECognomeDocente,codAula,numeroOreSettimanali,numeroOrePerLezione)
                if(tipo == "laboratorio"):
                    line = f.readline().strip()
                    nomeLaboratorio = line
                    line = f.readline().strip()
                    nomeAssistente = line
                    line = f.readline().strip()
                    nummeroPostazioniNelLaboratorio = int(line)
                    c = Laboratorio(cod,tipo,nomeDelCorso,nomeECognomeDocente,nomeLaboratorio,nomeAssistente,nummeroPostazioniNelLaboratorio)
                CodNome[cod]=nomeDelCorso
                corsi.append(c)
                line = f.readline().strip()
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        try:
            f=open("studenti.txt","r")
            line = f.readline().strip()
            while(line != ''):
                matricola = int(line)
                line = f.readline().strip()
                nomeECognome = line
                s = Studenti(matricola,nomeECognome)
                line = f.readline().strip()
                while(line != ''):
                    tok = line.split()
                    codCorso = int(tok[0])
                    voto     = str(tok[1])
                    cc = CorsiSeguiti(codCorso,voto)
                    s.addCorsiSeguiti(cc)
                    line = f.readline().strip()
                studenti.append(s)
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)     

        print("nome, codice, docente, tipo, aula, ore sett., ore/lez., lab.,assistente, postazioni ")
        for c in corsi:
            print(c)

        print(" ")

        for s in studenti:
            print(s)

        print(" ")
  
        for s in studenti:
            if (s.getMatricola() == int(sys.argv[1])):
                print(s.getNome() +" " +CodNome[s.getCodCorsoVotoMagg()] +" " +str(s.getVotoMagg()))
        
if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()