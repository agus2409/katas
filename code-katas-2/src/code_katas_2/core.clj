(ns code-katas-2.core)


(defn unpartial
  "Escribir una funcion que acepte una funcion parcial con cantidad de argumentos desconocida,
   retornar una funcion equivalente de n argumentos"
  [f]
  
 (fn[ & args]
   (if (= (count args) 1)
    (if (fn?(f(first (first args))))
      ((unpartial (f(first (first args)))) (rest (first args)))
      (f(first (first args)))
    )
    (if (fn?(f(first args)))
      ((unpartial (f(first args))) (rest args))
    )
   )
 )
 )


(defn search
  "Dado un numero cualquiera de secuencias, cada una ya ordenada de menor a mayor, encontrar el numero
   mas chico que aparezca en todas las secuencias, las secuencias pueden ser infinitas."
  [& seqs]
;dentro de una lazy-seq tomo el primero de una de las secuencias si esta en las restantes listas lo dejo sino lo tiro
;mando recursivo con las nuevas listas
(defn remover [sequ x]
  (map #(if (= (first %) x) (drop 1 %) %) sequ))
 
 
(if (not-any? false? (map #(=(first %) (first (sort (map first seqs)))) seqs))
  (first (sort (map first seqs)))
  (recur (remover seqs (first (sort (map first seqs)))))
)
)
   

(defn intercalar
  "Escriba una funcion que tome un predicado de 2 argumentos, un valor y una coleccion, y
   retorne una nueva coleccion donde el valor es insertado intercalado cada dos argumentos
   que cumplan el predicado"
  [predicado valor secuencia]
  
  (lazy-seq
    (if (not (empty? secuencia))
    (if (and (not (nil? (second secuencia))) (predicado (first secuencia) (second secuencia)))             
      (conj (first secuencia) valor (intercalar predicado valor (rest secuencia)))
      (conj (first secuencia) (intercalar predicado valor (rest secuencia)))
    )
    )
    )
)

(defn tartamudeo
  "Escriba una funcion que retorne una secuencia lazy que comprima el tartamudeo de una secuencia de numeros.
   Comprimir el tartamudeo se refiere a que [1 1 1] se exprese como [3 1] y a su vez [3 1] se exprese como [1 3 1 1].

   La funcion debe aceptar una secuencia inicial de numeros, y devolver una secuencia infinita de compresiones, donde
   cada nuevo elemento es el elemento anterior comprimido."
  [secuencia]
;(iterate funcion secuencia)
)
;(intercalar < :menor [2 6 9 4 3])
(conj :menor :mayor)