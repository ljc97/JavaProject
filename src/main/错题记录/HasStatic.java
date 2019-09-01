/**
 * @Author Linjc
 * @Description /
 * @date 2019/8/21
 */
class HasStatic{
    public static int x = 100;
    public static void main(String args[ ]){
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1=new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println( "x=" +x);
    }
}
class Test{
    public static void main(String[] args) {
        HasStatic hasStatic = new HasStatic();
//        System.out.println(hasStatic.x);
        System.out.println(HasStatic.x);

    }

}
