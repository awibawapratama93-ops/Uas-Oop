package dao;

import java.util.List;

// Interface ini adalah "kontrak" yang wajib dipenuhi setiap DAO.
// Tipe generic <T> artinya interface ini bisa dipakai untuk model apa saja
// (Boat, Route, Passenger, dst) tanpa perlu bikin interface terpisah untuk masing-masing.
public interface CrudDAO<T> {
    int insert(T item);
    List<T> getAll();
    int update(T item);
    int delete(int id);
}