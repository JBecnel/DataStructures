public class FavoriteList extends ListADT<Favorite> {
    private static final int MAX_FAVORITES = 50;
    private Favorite[] favorites;
    private int numFavorites;

    public FavoriteList() {
        this.numFavorites = 0;
        this.favorites = new Favorite[MAX_FAVORITES];
    }

    @Override
    public boolean isEmpty() {
        return this.numFavorites == 0;
    }

    @Override
    public int size() {
        return this.numFavorites;
    }

    @Override
    public void removeAll() {
        this.favorites = new Favorite[MAX_FAVORITES];
        this.numFavorites = 0;
    }

    @Override
    public void add(int index, Favorite item) throws ListException {
        if (index < 0 || index > this.size())
            throw new ListException("Index " + index + " is invalid for a list of size " + this.size());

        if (index >= MAX_FAVORITES)
            throw new ListException("Index exceeds maximum allowed size of the list: " + MAX_FAVORITES);

        for (int i = this.size(); i > index; i--)
            this.favorites[i] = this.favorites[i - 1];

        this.favorites[index] = item;
        this.numFavorites++;

    }

    @Override
    public Favorite get(int index) throws ListException {
        if ((index < 0)|| (index >= this.size()))
				throw new ListException("Index " + index + " is invalid for a list of size " + this.size());
		
		return this.favorites[index];

    }

    @Override
    public void remove(int index) throws ListException {
        if ((index < 0) || (index >= this.size()))
				throw new ListException("Index " + index + " is invalid for a list of size " + this.size());

			for (int position = index + 1; position < this.size(); position++)
				this.favorites[position - 1] = this.favorites[position];

			this.numFavorites--;

    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.size(); i++) {
            s = s + i + ": " + this.get(i) + "\n";
        }
        return s;
    }
}
