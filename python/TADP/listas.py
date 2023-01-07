class Nodo:
	#INSERTAR y ELIMINAR
	def __init__(self, valor, pos = 0):
		self.valor = valor;
		self.enlace = None;
		self.pos = pos;

	def crearEnlace(self, enlace):
		self.enlace = enlace;
		self.enlace.setPos(self.pos+1)

	def crearNodo(self, enlace):
		nodo = self.getUltimoNodo()
		nodo.crearEnlace(enlace);

	def getEnlace(self): #MANEJO DE ERRORES
		try:
			return self.enlace;
		except:
			return None;

	def getValor(self):
		return self.valor;

	def getUltimoNodo(self):
		if self.enlace is not None:
			return self.enlace.getUltimoNodo();
		else:
			return self

	def printNodos(self,nodo):
		if nodo.enlace is not None:
			print("POS: ",nodo.getPos(),"DIRECCION MEMORIA: ", nodo , "VALOR: ", nodo.getValor(), "ENLACE: ", nodo.getEnlace())
			return self.printNodos(nodo.getEnlace());
		else:
			print("POS: ",nodo.getPos()," ULTIMO VALOR DIRECCION MEMORIA: ", nodo , "VALOR: ", nodo.getValor(), "ENLACE: ", nodo.getEnlace() )
			return nodo;

	def eliminar(self,nodo,pos):
		if nodo.getPos() == pos:
			print("ELIMINAR NODO: ",nodo)
			return True
		else:
			if nodo.enlace is not None:
				return self.eliminar(nodo.getEnlace(),pos);
			else:
				return -1;

	def size(self,nodo):
		if nodo.enlace is not None:
			return 1 + self.size(nodo.getEnlace());
		else:
			return 1;

	def setPos(self,pos):
		self.pos = pos;

	def getPos(self):
		return self.pos;

print("********Nodo 1")
n1 = Nodo("nodo1")
print("POS: ",n1.getPos()," DIRECCION MEMORIA: ", n1 , "VALOR: ", n1.getValor(), "ENLACE: ", n1.getEnlace() )
n1.crearEnlace(Nodo("nodo2"))
print("POS: ",n1.getPos()," DIRECCION MEMORIA: ", n1 , "VALOR: ", n1.getValor(), "ENLACE: ", n1.getEnlace() )

print("********Nodo 2")
n2 = n1.getEnlace()
print("POS: ",n2.getPos()," DIRECCION MEMORIA: ", n2 , "VALOR: ", n2.getValor(), "ENLACE: ", n2.getEnlace() )
n2.crearEnlace(Nodo("nodo3"))
print("POS: ",n2.getPos()," DIRECCION MEMORIA: ", n2 , "VALOR: ", n2.getValor(), "ENLACE: ", n2.getEnlace() )

print("********Nodo 3")
n3 = n2.getEnlace()
print("POS: ",n3.getPos()," DIRECCION MEMORIA: ", n3 , "VALOR: ", n3.getValor(), "ENLACE: ", n3.getEnlace() )


print("-----------------  ÚLTIMO NODO")
nodo = n1.getUltimoNodo();
print("POS: ",nodo.getPos(),"DIRECCION MEMORIA: ", nodo, "VALOR: ", nodo.getValor(), "ENLACE: ", nodo.getEnlace() )

for i in range(3,100,1):
	val = "nodo " + str(i+1)
	nodo.crearNodo(Nodo(val));
("--------------------------------------------------")
n1.printNodos(n1);
print("SIZE: ",n1.size(n1));

n1.eliminar(n1,40);