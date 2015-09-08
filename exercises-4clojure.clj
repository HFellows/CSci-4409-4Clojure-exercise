;;; Put your solutions to the assigned 4Clojure exercises here and commit
;;; back up to your fork on Github.

;;; What you enter is what whatever you'd put in the "Code which fills in the blank"
;;; box in 4Clojure. You're welcome to include other things here (helper definitions,
;;; scratch computations you found helpful, etc.), SO MAKE SURE YOU LABEL YOUR
;;; "ANSWERS" clearly.

;;; I've included a few examples below just to give you a sense of what I'm looking
;;; for.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #162: Logical falsity and true

; What I pasted in the box:

1

; because all the given expressions returned 1, for example:

(= 1 (if [] 1 0))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #15: Double Down

; What I pasted in the box:

#(* 2 %)

; which is an anonymous function that doubles its argument, for example:

(= (#(* 2 %) 11) 22)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #10: Intro to Maps
 
; What I pasted in the box:

20

; because all the given expressions returned 20, for example:

(= 20 (:b {:a 10, :b 20, :c 30}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #10: Intro to Maps
 
; What I pasted in the box:

20

; because all the given expressions returned 20, for example:

(= 20 (:b {:a 10, :b 20, :c 30}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #16: Hello World
 
; What I pasted in the box:

(fn [x] (str "Hello, " x "!"))

; which is a lambda that surrounds it's argument with "Hello, " and "!"

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #17: Sequences: map
 
; What I pasted in the box:

'(6 7 8)
 
 ; because the given expression returned '(6 7 8), for example:
 
 (= '(6 7 8) (map #(+ % 5) '(1 2 3)))
 
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #18: Sequences: filter
 
; What I pasted in the box:

'(6 7)

; because the given expression returned '(6 7 8), for example:
 
 (= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))
 
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #20: Sequences: filter
 
; What I pasted in the box:

(fn [coll] (second (reverse coll)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #21: Nth Element
 
; What I pasted in the box:

(fn [coll n] 
   (loop [sq coll depth 0]
    (if (= depth n)
      (first sq)
      (recur (rest sq) (+ depth 1))
      )))
    
;tail recursion hack used with a depth counter.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #23: Reverse a sequence 

; What I pasted in the box:

(fn [coll]
  (loop [[ele & more :as everything] (vec coll)
         acc '()]
    (if everything 
        (recur more (cons ele acc))
      acc)))

; did you know that arg or binding vectors behave exactly the same in all contexts?

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #25: Find an odd number 

; What I pasted in the box:

(fn [coll] (filter odd? coll))

; . . .

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #37: Regular Expression

"ABC"

;Who would have guessed?

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #40: Interpose a seq

;Let's go back to the basics
(fn [e c]
  (loop [coll (vec c) acc []]
        ;vectors are the best!
    (if (empty? (rest coll))
      (conj acc (first coll))
      (recur (rest coll) (conj (conj acc (first coll)) e))
      )))

;More reasons why I hate conj / the lack of a coercive append. 
;Interposes elements into a seq by taking elements one by one (except for the last one) 
;and adding them along with the separator to an accumulator.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #43: Reverse interleave

;Map is awesome. Also, I may have done all of these and just am showing off.
(fn [coll n] (apply map vector (partition n coll)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #44: Rotate sequence

;This was tricky as hell:
;My first version was this - using  cycle to create an infinite string of the collection,
;and then just grabbing the section I needed. I forgot that lazy seqs don't exist in the negative direction

;(fn [n coll] (let [c (count coll)]
;               (take c (drop n (cycle coll)))
;               ))

;Then I remembered that modulo exists and that I could use it

(fn [n coll] (let [c (count coll)
                   modulized (mod n c)]
               (take c (drop modulized (cycle coll)))
               ))
             
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #46: Flipping out

;This was actually one of the easier problems for me. 

(fn [a-fn] 
    (fn [& args] (apply a-fn (reverse args)))
    )

;returns a lambda that reverses the order of it's given args before handing them to it's core function.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;; Problem #47: Contain yourself

;I realized I never use contains?. This is a good thing.
; What I pasted in the box:

4

; Which works for each example because . . .
;1) The members of a set are the keys of those elements.
;2) The index 4 exists.
;3) 4 is in a key position in the map (while not being the key type externally).
;4) the example does not contain an index 4.
