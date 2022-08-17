#ifndef DELETELANDWINDOW_H
#define DELETELANDWINDOW_H

#include <QWidget>

namespace Ui {
class DeleteLandWindow;
}

class DeleteLandWindow : public QWidget
{
    Q_OBJECT

public:
    explicit DeleteLandWindow(QWidget *parent = nullptr);
    ~DeleteLandWindow();

private:
    Ui::DeleteLandWindow *ui;
};

#endif // DELETELANDWINDOW_H
