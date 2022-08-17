#ifndef DELETEPERSONWINDOW_H
#define DELETEPERSONWINDOW_H

#include <QWidget>

namespace Ui {
class DeletePersonWindow;
}

class DeletePersonWindow : public QWidget
{
    Q_OBJECT

public:
    explicit DeletePersonWindow(QWidget *parent = nullptr);
    ~DeletePersonWindow();

private:
    Ui::DeletePersonWindow *ui;
};

#endif // DELETEPERSONWINDOW_H
