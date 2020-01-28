import 'package:flutter/material.dart';

class Home extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Sweety'),
        backgroundColor: Colors.red[400],
        centerTitle: true,
      ),
      drawer: Drawer(
        child: ListView(
          children: <Widget>[
            DrawerHeader(
                decoration: BoxDecoration(
                  gradient: LinearGradient(
                      colors: <Color>[Colors.deepOrange, Colors.orangeAccent]),
                ),
                child: Text('Sweety App')),
            CustomListTitle(Icons.home, 'Home', () => {}),
            CustomListTitle(Icons.shopping_cart, 'Shopping cart', () => {}),
            CustomListTitle(Icons.person, 'Profile', () => {}),
          ],
        ),
      ),
    );
  }
}

class CustomListTitle extends StatelessWidget {
  IconData icon;
  String title;
  Function onTap;

  CustomListTitle(this.icon, this.title, this.onTap);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.fromLTRB(8.0, 0, 8.0, 0),
      child: InkWell(
        splashColor: Colors.orange,
        onTap: () => {},
        child: Container(
          height: 40,
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: <Widget>[
              Row(
                children: <Widget>[
                  Icon(icon),
                  Padding(
                    padding: const,
                  ),
                  Text(
                    title,
                    style: TextStyle(
                      fontSize: 16.0,
                      color: Colors.deepPurple,
                    ),
                  )
                ],
              )
            ],
          ),
        ),
      ),
    );
  }
}
                                                                                                                                                                                                                                                                                                                         