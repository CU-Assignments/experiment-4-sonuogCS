class Movie:
    def __init__(self, title, genre, quantity):
        self.title = title
        self.genre = genre
        self.quantity = quantity
        self.rented = 0  # Tracks the number of rented copies

    def rent(self):
        if self.quantity > self.rented:
            self.rented += 1
            print(f"Movie '{self.title}' rented successfully!")
        else:
            print(f"Sorry, '{self.title}' is currently out of stock.")

    def return_movie(self):
        if self.rented > 0:
            self.rented -= 1
            print(f"Movie '{self.title}' returned successfully!")
        else:
            print(f"Error: No rentals for '{self.title}' to return.")

    def available(self):
        return self.quantity - self.rented

    def __str__(self):
        return f"Title: {self.title}, Genre: {self.genre}, Available: {self.available()}, Total: {self.quantity}"


class Inventory:
    def __init__(self):
        self.movies = {}

    def add_movie(self, title, genre, quantity):
        if title in self.movies:
            self.movies[title].quantity += quantity
        else:
            self.movies[title] = Movie(title, genre, quantity)
        print(f"Movie '{title}' added with {quantity} copies.")

    def remove_movie(self, title):
        if title in self.movies:
            del self.movies[title]
            print(f"Movie '{title}' removed from inventory.")
        else:
            print(f"Movie '{title}' not found in inventory.")

    def list_movies(self):
        if not self.movies:
            print("No movies available.")
        for movie in self.movies.values():
            print(movie)

    def rent_movie(self, title):
        if title in self.movies:
            self.movies[title].rent()
        else:
            print(f"Movie '{title}' not found in inventory.")

    def return_movie(self, title):
        if title in self.movies:
            self.movies[title].return_movie()
        else:
            print(f"Movie '{title}' not found in inventory.")

    def available_movies(self):
        print("Available movies:")
        for movie in self.movies.values():
            if movie.available() > 0:
                print(movie)


# Simulating the inventory control system
def main():
    store_inventory = Inventory()

    # Add some movies to the inventory
    store_inventory.add_movie("Inception", "Sci-Fi", 5)
    store_inventory.add_movie("Titanic", "Romance", 3)
    store_inventory.add_movie("The Godfather", "Crime", 4)

    # List all movies
    print("\n--- List of Movies in Inventory ---")
    store_inventory.list_movies()

    # Rent a movie
    print("\n--- Rent a Movie ---")
    store_inventory.rent_movie("Inception")
    store_inventory.rent_movie("Titanic")

    # View available movies
    print("\n--- Available Movies ---")
    store_inventory.available_movies()

    # Return a movie
    print("\n--- Return a Movie ---")
    store_inventory.return_movie("Inception")

    # View updated available movies
    print("\n--- Updated Available Movies ---")
    store_inventory.available_movies()

    # Remove a movie
    print("\n--- Remove a Movie ---")
    store_inventory.remove_movie("The Godfather")

    # List all movies after removal
    print("\n--- Final List of Movies ---")
    store_inventory.list_movies()


if __name__ == "__main__":
    main()
