# Robinson-Algorithm-PGCU
## Project Summary: Predicate Calculus Unifier (PGCU)

  The Predicate Calculus Unifier (PGCU) project aims to implement an algorithm to find the Most General Unifier (MGU) for given     logical predicates. It consists of three main parts:

  Application:
    - Classes:
      - PGCU: Implements the Robinson algorithm for finding the Most General Unifier (MGU).
      - Teta: Manages theta substitution for the Robinson algorithm.
      - Diff: Handles the differences between predicates.
      
  ### Métier (Core Logic):
    - Classes:
      - Terme, Litteral, Skolem: Represent different types of terms used in logical predicates.
      - Variable, Fonction, Constante: Specific types of terms extending the basic term classes.
      - Predicat: Models logical predicates and their behavior.
      
  ### Graphical User Interface (GUI):
    - Class:
      - Fenetre: Creates the graphical interface allowing users to input predicates, trigger the PGCU calculation, and display the results.

      
  ### Functionality:
    - Robinson Algorithm:
      Implemented in the PGCU class to compute the Most General Unifier (MGU) for given logical predicates.
      Utilizes various classes (Teta, Diff) to manage substitutions and differences between predicates.
    
    - GUI Interaction:
        Allows users to input logical predicates visually.
        Provides a button to trigger the PGCU calculation and displays the resulting calculation.        
      
   Usage:
    1. Run the application to open the graphical interface (Fenetre class).
    2. Enter logical predicates A and B in the respective input fields.
    3. Click the "Calculer" button to execute the PGCU algorithm.
    4. View the computed result displayed in the GUI.
