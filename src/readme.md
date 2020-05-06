khoa tu dong tang khi insert 

ResultSet rs=statement.getGeneratedKeys(); 
if(rs.next()){
    int maDanhMuc = rs.getInt(1);
    System.out.println("Mã danh mục vừa thêm: "+maDanhMuc);
}
